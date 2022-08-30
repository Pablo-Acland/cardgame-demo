import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

//TODO: componente home para redireccion y enrutado
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  listgames(){
    this.router.navigate(['list']);
  }
}
