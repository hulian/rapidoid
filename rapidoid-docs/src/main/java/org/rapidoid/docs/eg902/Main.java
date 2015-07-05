package org.rapidoid.docs.eg902;

import org.rapidoid.annotation.App;
import org.rapidoid.quick.Quick;

/*
 * #%L
 * rapidoid-docs
 * %%
 * Copyright (C) 2014 - 2015 Nikolche Mihajlovski and contributors
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

// Customize login options in the login menu :: Show Facebook and Google login menu items

@App
public class Main {
	String title = "Facebook or Google";
	Object content = "Hello!";
	String theme = "3";

	boolean full = false; // here
	boolean facebookLogin = true; // here
	boolean googleLogin = true; // here

	public static void main(String[] args) {
		Quick.run(args);
	}
}
