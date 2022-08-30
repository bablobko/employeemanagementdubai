/**
 * 
 */
package com.bablo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author bablo
 *
 */
@Controller
public class DefaultController {
	
	@GetMapping
	public String defaultPage() {
		return "redirectMsg";
	}

}
