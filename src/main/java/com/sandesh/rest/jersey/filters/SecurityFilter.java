package com.sandesh.rest.jersey.filters;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;


/**
 * Unable to decode the passed string 
 * Still unable to know the problem
 * Implemented without decoding anything. If possible try decoding
 * This basic auth is for username: sandesh and password: sandesh
 * Encoded representation for this is c2FuZGVzaDpwb2tocmVs
 */
// @Provider
public class SecurityFilter implements ContainerRequestFilter {
	
	private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
	private static final String AUTHORIZATION_HEADER_PREFIX = "Basic ";

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		String authToken = requestContext.getHeaderString(AUTHORIZATION_HEADER_KEY);
		authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
		System.out.println(authToken);
		if (authToken.equalsIgnoreCase("c2FuZGVzaDpwb2tocmVs")) return;
		Response authResponse = Response.status(Status.UNAUTHORIZED).entity("Unauthorized request").build();
		requestContext.abortWith(authResponse);
//		String decodedString = Base64.decodeBase64(authToken).toString();
//		System.out.println(decodedString);
	}

}
