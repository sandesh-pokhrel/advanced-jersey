package com.sandesh.rest.jersey.filters;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

import com.sandesh.rest.jersey.exceptions.InvalidSessionException;

// @Provider
public class AuthenticationFilter implements ContainerRequestFilter {

	/**
	 * This is not the recommended way. Simply a header with key sessionAuth is passed in the request
	 */
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		String session = requestContext.getHeaderString("sessionAuth");
		if (session == null || !session.equals("sandesh_pokhrel")) {
			System.out.println("Invalid session");
			throw new InvalidSessionException("Invalid session");
		}
	}

}
