/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
package com.lti.itops.ipac.custcatmgmt.exception;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author sunprabh
 */
@ProviderType
public class NoSuchTTechnologyCustomerMapException extends NoSuchModelException {

	public NoSuchTTechnologyCustomerMapException() {
	}

	public NoSuchTTechnologyCustomerMapException(String msg) {
		super(msg);
	}

	public NoSuchTTechnologyCustomerMapException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchTTechnologyCustomerMapException(Throwable cause) {
		super(cause);
	}

}