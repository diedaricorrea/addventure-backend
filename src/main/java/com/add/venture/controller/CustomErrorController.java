package com.add.venture.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.add.venture.helper.UsuarioAutenticadoHelper;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class CustomErrorController implements ErrorController {

    @Autowired
    private UsuarioAutenticadoHelper usuarioAutenticadoHelper;

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        // Cargar datos del usuario para la navbar si está autenticado
        try {
            usuarioAutenticadoHelper.cargarDatosUsuarioParaNavbar(model);
        } catch (Exception e) {
            // Si hay error cargando datos de usuario, continuar sin ellos
        }

        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        
        // Determinar si estamos en modo desarrollo
        String serverName = request.getServerName();
        boolean isDevelopment = "localhost".equals(serverName) || "127.0.0.1".equals(serverName);
        model.addAttribute("isDevelopment", isDevelopment);
        
        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());
            
            // Información del error para debugging
            String errorMessage = (String) request.getAttribute(RequestDispatcher.ERROR_MESSAGE);
            String requestUri = (String) request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI);
            
            model.addAttribute("statusCode", statusCode);
            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("requestUri", requestUri);
            
            // Redireccionar a páginas específicas según el código de error
            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                model.addAttribute("errorTitle", "Página No Encontrada");
                model.addAttribute("errorDescription", "La página que buscas no existe o ha sido movida");
                model.addAttribute("errorIcon", "bi-search");
                model.addAttribute("errorType", "404");
                return "error/404";
            }
            else if (statusCode == HttpStatus.FORBIDDEN.value()) {
                model.addAttribute("errorTitle", "Acceso Denegado");
                model.addAttribute("errorDescription", "No tienes permisos para acceder a esta página");
                model.addAttribute("errorIcon", "bi-shield-x");
                model.addAttribute("errorType", "403");
                return "error/403";
            }
            else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                model.addAttribute("errorTitle", "Error del Servidor");
                model.addAttribute("errorDescription", "Ha ocurrido un error interno. Nuestro equipo está trabajando para solucionarlo");
                model.addAttribute("errorIcon", "bi-exclamation-triangle");
                model.addAttribute("errorType", "500");
                return "error/500";
            }
            else if (statusCode == HttpStatus.UNAUTHORIZED.value()) {
                model.addAttribute("errorTitle", "Acceso No Autorizado");
                model.addAttribute("errorDescription", "Necesitas iniciar sesión para acceder a esta página");
                model.addAttribute("errorIcon", "bi-person-x");
                model.addAttribute("errorType", "401");
                return "error/401";
            }
            else if (statusCode == HttpStatus.BAD_REQUEST.value()) {
                model.addAttribute("errorTitle", "Solicitud Incorrecta");
                model.addAttribute("errorDescription", "La solicitud no pudo ser procesada correctamente");
                model.addAttribute("errorIcon", "bi-exclamation-circle");
                model.addAttribute("errorType", "400");
                return "error/400";
            }
        }
        
        // Error genérico para códigos no específicos
        model.addAttribute("errorTitle", "Error Inesperado");
        model.addAttribute("errorDescription", "Ha ocurrido un error inesperado");
        model.addAttribute("errorIcon", "bi-bug");
        model.addAttribute("errorType", "generic");
        return "error/generic";
    }
} 