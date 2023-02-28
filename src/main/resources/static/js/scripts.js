/*!
* Start Bootstrap - Agency v7.0.11 (https://startbootstrap.com/theme/agency)
* Copyright 2013-2022 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-agency/blob/master/LICENSE)
*/
//
// Scripts
// 

window.addEventListener('DOMContentLoaded', event => {

	// Navbar shrink function
	var navbarShrink = function() {
		const navbarCollapsible = document.body.querySelector('#mainNav');
		var URLactual = window.location.pathname;
		if (!navbarCollapsible) {
			return;
		}
		console.log(URLactual)
		if (URLactual === '/' || URLactual === '/index' || URLactual === '') {
			if (window.scrollY === 0) {
				navbarCollapsible.classList.remove('navbar-shrink')
			} else {
				navbarCollapsible.classList.add('navbar-shrink')
			}
		} else {
			navbarCollapsible.classList.add('navbar-shrink')
		}
	};

	// Shrink the navbar 
	navbarShrink();

	// Shrink the navbar when page is scrolled
	document.addEventListener('scroll', navbarShrink);

	// Activate Bootstrap scrollspy on the main nav element
	const mainNav = document.body.querySelector('#mainNav');
	if (mainNav) {
		new bootstrap.ScrollSpy(document.body, {
			target: '#mainNav',
			offset: 74,
		});
	};

	// Collapse responsive navbar when toggler is visible
	const navbarToggler = document.body.querySelector('.navbar-toggler');
	const responsiveNavItems = [].slice.call(
		document.querySelectorAll('#navbarResponsive .nav-link')
	);
	responsiveNavItems.map(function(responsiveNavItem) {
		responsiveNavItem.addEventListener('click', () => {
			if (window.getComputedStyle(navbarToggler).display !== 'none') {
				navbarToggler.click();
			}
		});
	});

	$(document).ready(function() {
		$("#input-id").fileinput({
			theme: 'fas',
			showUpload: false,
			showCaption: false,
			browseClass: "btn btn-primary btn-lg",
			fileType: "any",
			previewFileIcon: '<i class="fas fa-file"></i>',
			browseLabel: "Seleccionar archivo",
			initialPreviewAsData: true,
			initialPreviewFileType: 'image',
			initialPreview: [
				// lista de URLs o datos base64 de imágenes previas (opcional)
			],
			initialPreviewConfig: [
				// lista de configuraciones de imágenes previas (opcional)
			],
			deleteUrl: '/ruta/a/eliminar', // URL para eliminar archivos cargados (opcional)
			overwriteInitial: false, // si es verdadero, permite la sobrescritura de archivos previamente cargados (opcional)
			maxFileSize: 10000, // tamaño máximo del archivo en KB (opcional)
			maxFileCount: 1, // número máximo de archivos permitidos (opcional)
			allowedFileTypes: ['image', 'pdf', 'docx'], // tipos de archivo permitidos (opcional)
			allowedFileExtensions: ['jpg', 'jpeg', 'png', 'pdf', 'docx'] // extensiones de archivo permitidas (opcional)
		});
	});
});
