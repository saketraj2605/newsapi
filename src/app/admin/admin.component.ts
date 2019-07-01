import { Component, OnInit } from '@angular/core';
import {AdminService} from './admin.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  
  list:Array<any>;
  blacklist:boolean;
  constructor(private adminService: AdminService) { }

  ngOnInit() {
    this.adminService.list().subscribe(data => this.list = data);
    console.log(this.list);
  }

  blockUser(lists)
  {
    this.adminService.blockUser(lists).subscribe(data=>this.blacklist = data);
    this.adminService.list().subscribe(data => this.list = data);
  }

  }
