$(document).ready(function(){
	


$('.btnconsultar').on('click',function(){
	alert("consulta")
	consultarusuraio();
	
});	


	function consultarusuraio(){
		alert("en el metodo")
	$.ajax({
		
	  url: "Consultas",
	  type:"POST",
	  dataType:'json',
	  success: function( datos ) {
		console.log(datos);
		let tab=document.getElementById('tabla');
		//console.log(tab);
		tab.innerHTML='';
		tab.innerHTML+=`<tr><th>Documento</th>
		                <th>Usuario</th>
						<th>Clave</th>
						<th>Rol</th>
					    <th>Estado</th></tr>  `;
	
			for(let i of datos){
			 tab.innerHTML+=`<tr>
			  					 <td>${i.documento}</td>
								 <td>${i.nomusuario}</td>	
							     <td>${i.clave}</td>
								 <td>${i.rol}</td>
							     <td>${i.estado}</td>
							 </tr> `;	
				
				
			}
	  }
	});
		
		
  }


	
});
