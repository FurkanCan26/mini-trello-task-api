package com.can.taskapi;

import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskRepository repo;

    public TaskController(TaskRepository repo) {
        this.repo = repo;
    }

    private static TaskDto toDto(Task t) {
        return new TaskDto(t.getId(), t.getTitle(), t.getDescription(), t.getStatus());
    }

    @GetMapping
    public List<TaskDto> list(@RequestParam(required = false) CardStatus status) {
        List<Task> tasks = (status == null)
                ? repo.findAll(Sort.by(Sort.Direction.DESC, "id"))
                : repo.findByStatus(status);

        return tasks.stream().map(TaskController::toDto).toList();
    }

    @PostMapping
    public ResponseEntity<TaskDto> create(@RequestBody TaskDto req) {
        String title = req.title() == null ? "" : req.title().trim();
        if (title.isEmpty()) return ResponseEntity.badRequest().build();

        Task t = new Task(
                title,
                req.description(),
                req.status() == null ? CardStatus.TODO : req.status()
        );

        return ResponseEntity.ok(toDto(repo.save(t)));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<TaskDto> changeStatus(@PathVariable Long id, @RequestBody Map<String, String> body) {
        Task t = repo.findById(id).orElse(null);
        if (t == null) return ResponseEntity.notFound().build();

        String statusStr = body.get("status");
        if (statusStr == null) return ResponseEntity.badRequest().build();

        t.setStatus(CardStatus.valueOf(statusStr));
        return ResponseEntity.ok(toDto(repo.save(t)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repo.existsById(id)) return ResponseEntity.notFound().build();
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
