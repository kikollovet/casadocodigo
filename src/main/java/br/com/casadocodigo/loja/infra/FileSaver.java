package br.com.casadocodigo.loja.infra;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileSaver {
	
	@Autowired
	private HttpServletRequest request;

	public String write(String baseFolder, MultipartFile file) {
		
		try {
//			String realPath = request.getServletContext().getRealPath("/" + baseFolder);
//			String path = realPath + "/" + file.getOriginalFilename();
//			file.transferTo(new File("C:/Kiko/Alura/JavaWeb/casadocodigo/src/main/webapp/images/" + file.getOriginalFilename()));
//			return baseFolder + "/" + file.getOriginalFilename();
			
			
//			String realPath = request.getServletContext().getRealPath("/"+baseFolder);
//            String path = realPath + "/" + file.getOriginalFilename();
//            
//            Path filepath = Paths.get("C:/Kiko/Alura/JavaWeb/casadocodigo/src/main/webapp/arquivos-sumario/", file.getOriginalFilename());
//            try (OutputStream os = Files.newOutputStream(filepath)) {
//                os.write(file.getBytes());
//            }
//            
//            file.transferTo(new File(path));
//            return baseFolder + "/" + file.getOriginalFilename();
//			correto
			String realPath = request.getServletContext().getRealPath("/" + baseFolder);
			String path = realPath + "/" + file.getOriginalFilename();
			file.transferTo(new File("C:/Kiko/Files/" + file.getOriginalFilename()));
			return baseFolder + "/" + file.getOriginalFilename();
			
//			String realPath = request.getServletContext().getRealPath("/" + baseFolder);
//			String path = realPath + "/" + file.getOriginalFilename();
//			file.transferTo(new File("C:/Kiko/Alura/JavaWeb/casadocodigo/src/main/webapp/resources/imagens/" + file.getOriginalFilename()));
//			return baseFolder + "/" + file.getOriginalFilename();
            
            
			
		} catch (IllegalStateException | IOException e) {
			throw new RuntimeException(e);
		}
		
	}
}
