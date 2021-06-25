import { Component, OnInit,Input  } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { NgbModalConfig, NgbModal} from '@ng-bootstrap/ng-bootstrap';
import { ApiService } from 'src/app/service/api.service';

@Component({
  selector: 'app-modal-insert',
  templateUrl: './modal-insert.component.html',
  styleUrls: ['./modal-insert.component.scss']
})
export class ModalInsertComponent implements OnInit {

  formulario: FormGroup;
  @Input() pessoa: Array<any>;
  

  constructor(private apiService:ApiService,
    private formBuilder: FormBuilder,
    config: NgbModalConfig, private modalService: NgbModal) {
    config.backdrop = 'static';
      config.keyboard = false;
   }

  ngOnInit(): void {
    this.configurarFormulario();
  }

  open(content) {
    this.modalService.open(content);
  }

  configurarFormulario(){
    this.formulario = this.formBuilder.group({
      nome: [null, Validators.required],
      sexo: [null, Validators.required],
      celular: [null, Validators.required],
      cpf: [null, Validators.required],
      dtNasc: [null, Validators.required],
      email: [null, Validators.required],
      endereco: [null, Validators.required,null, Validators.email]
    });
  }

  criar(content) {
    this.apiService.criar(this.formulario.value).subscribe(resposta => {
      this.pessoa.push(resposta);
      this.modalService.dismissAll(content);
      this.formulario.reset();
    });
  }

}
