import {Component, OnInit} from '@angular/core';
import {Todo} from "../../models/todo";
import {TodoService} from "../../services/todo.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-finished',
  templateUrl: './finished.component.html',
  styleUrls: ['./finished.component.css']
})
export class FinishedComponent implements OnInit {

  listFinished: Todo[] = [];

  constructor(private service: TodoService, private router: Router) {}

  ngOnInit(): void {
    this.findAll();
  }

  findAll(): void {
    this.service.findAll().subscribe((response) => {
      response.forEach((todo) => {
        if (todo.finished) {
          this.listFinished.push(todo);
        }
      });
    });
  }

  voltar(): void {
    this.router.navigate(['']).then(r => console.log('Retornando para a página principal'));
  }

}
