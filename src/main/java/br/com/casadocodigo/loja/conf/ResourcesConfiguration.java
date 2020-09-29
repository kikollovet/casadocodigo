//package br.com.casadocodigo.loja.conf;
//
//import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//public class ResourcesConfiguration extends WebMvcConfigurerAdapter {
//
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//    //registry.addResourceHandler("/images/**").addResourceLocations("/images/");
//    //registry.addResourceHandler("/arquivos-sumario/**").addResourceLocations("/arquivos-sumario/");
//    
//		
//		
//		//registry.addResourceHandler("/files/**", "/resources/**").addResourceLocations("file:/Kiko/Files/", "/resources/").resourceChain(true).addResolver(new PathResourceResolver());
//	registry.addResourceHandler("/files/**", "/resources/**").addResourceLocations("file:/Kiko/Files/", "/resources/");
//		
//		
//		
//		//registry.addResourceHandler("/files/**").addResourceLocations("file:/Kiko/Files/");
//    
//	//registry.addResourceHandler("/teste/**").addResourceLocations("file:/Kiko/Teste/");
//    //registry.addResourceHandler("/files/**", "/teste/**").addResourceLocations("file:/Kiko/Files/","file:/Kiko/Files/01/","file:/Kiko/Teste/").resourceChain(true);
//    }
//	
//	@Override
//	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//	    configurer.enable();
//	}
//}
