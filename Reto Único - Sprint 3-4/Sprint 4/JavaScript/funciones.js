// Formulario

$("#c-btn").hide();

function obtenerdatos() {

	$("#c-btn").show();
	$('#recomendaciones').hide();

	var cedula = document.getElementById("cedula").value;
	var apellido = document.getElementById("apellido").value;
	var nombre = document.getElementById("nombre").value;
	var edad = document.getElementById("edad").value;
	var peso = document.getElementById("peso").value;
	var talla = document.getElementById("talla").value;

	edad1 = parseInt(edad);

	a = parseFloat(peso);

	b = parseFloat(talla);

	c = a / (b ** 2);

	c1 = parseFloat(c);

	var imc = c1.toFixed(1);

	var clasif;

	var cont_del = 0;
	var cont_normal = 0;
	var cont_sobrepeso = 0;
	var cont_obesidad = 0;

	cont_obesidad1 = parseInt(cont_obesidad);

	if (imc < 18.5){
		clasif = "Delgado";
		cont_del++;
	} else if (imc > 18.6 && c < 24.9){
		clasif = "Normal";
		cont_normal++;
	} else if (imc > 25 && c < 29.9){
		clasif = "Sobrepeso";
		cont_sobrepeso++;
	} else if (imc > 30){
		clasif = "Obesidad";
		cont_obesidad1++;
	}

	var recomendacionImc;

	if (clasif === "Delgado"){
		recomendacionImc = "Come más";
	} else if (clasif === "Normal"){
		recomendacionImc = "Sigue así";
	} else if (clasif === "Sobrepeso"){
		recomendacionImc = "Trata de comer más verduras";
	} else if (clasif === "Obesidad"){
		recomendacionImc = "No comas tantas grasas saturadas";
	}
	
	document.form.cedulaobtenido.value = cedula;
	document.form.apellidoobtenido.value = apellido;
	document.form.nombreobtenido.value = nombre;
	document.form.edadobtenido.value = edad1;
	document.form.pesoobtenido.value = a;
	document.form.tallaobtenido.value = b;
	document.form.imcobtenido.value = imc;
	document.form2.clasificacionobtenido.value = clasif;
	document.form2.recomendacionobtenido.value = recomendacionImc;
}

// Recomendaciones

$('#recomendaciones').hide();

function mostrarRc(){
	// document.getElementById('recomendaciones').style.display = 'block';
	
	let text = "";

	if($("#btn2").text() === "Mostrar Recomendaciones"){
		$("#recomendaciones").show();
		text = "Ocultar Recomendaciones";
	} else {
		$("#recomendaciones").hide();
		text = "Mostrar Recomendaciones";
	}

	$("#btn2").html(text);
}

function ocultarRc(){
	$("#c-btn").hide();
	$('#recomendaciones').hide();
}

// Botón Ctrl

function boton() {
	alert("Hola");
}

// Otros

var objeto = [
	{
		cedula: "",
		apellido: "",
		nombre: "",
		edad: "",
		a: "",
		b: "",
		c: "",
		clasif: ""
	}
]

const handleClickReset = () => {
	document.form.cedulaobtenido.value = '';
	document.form.apellidoobtenido.value = '';
	document.form.nombreobtenido.value = '';
	document.form.edadobtenido.value = '';
	document.form.pesoobtenido.value = '';
	document.form.tallaobtenido.value = '';
	document.form.imcobtenido.value = '';
}