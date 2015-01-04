package org.rapidoid.prop;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;

import org.rapidoid.util.TypeKind;

/*
 * #%L
 * rapidoid-utils
 * %%
 * Copyright (C) 2014 - 2015 Nikolche Mihajlovski
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

public interface Prop {

	<T> T get(Object target);

	<T> T get(Object target, T defaultValue);

	void set(Object target, Object value);

	String getName();

	boolean isReadOnly();

	Class<?> getType();

	TypeKind getTypeKind();

	ParameterizedType getGenericType();

	<T extends Annotation> T getAnnotation(Class<T> annotationClass);

	int typeArgsCount();

	Class<?> typeArg(int index);

}