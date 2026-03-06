import { Component, OnInit, inject } from '@angular/core';
import { FormsModule } from '@angular/forms'; // 1. Importar esto
import { TaskService } from './services/task.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [FormsModule], // 2. Añadir esto
  template: `
    <h1>Mis Tareas</h1>

    <input [(ngModel)]="newTaskTitle" placeholder="Escribe una tarea...">
    <button (click)="addTask()">Añadir</button>

    <ul>
      @for (task of tasks; track task.id) {
        <li>{{ task.title }}</li>
      }
    </ul>
  `
})
export class AppComponent implements OnInit {
  tasks: any[] = [];
  newTaskTitle: string = ''; // Variable del input
  taskService = inject(TaskService);

  ngOnInit() {
    this.loadTasks();
  }

  loadTasks() {
    this.taskService.getTasks().subscribe(data => this.tasks = data);
  }

  addTask() {
    if (!this.newTaskTitle.trim()) return;
    this.taskService.createTask({ title: this.newTaskTitle, completed: false }).subscribe(() => {
      this.newTaskTitle = ''; // Limpiar campo
      this.loadTasks();       // Recargar lista
    });
  }
}
