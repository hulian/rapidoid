package org.rapidoid.http;

/*
 * #%L
 * rapidoid-integration-tests
 * %%
 * Copyright (C) 2014 - 2016 Nikolche Mihajlovski and contributors
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

import org.junit.Test;
import org.rapidoid.annotation.Authors;
import org.rapidoid.annotation.Since;
import org.rapidoid.setup.On;

@Authors("Nikolche Mihajlovski")
@Since("5.1.0")
public class HttpPathMatchingTest extends IntegrationTestCommons {

	@Test
	public void testHttpPathMatching() {
		On.get("/movies/{id}").json((Req req) -> req.params());
		On.post("/users/{x}/").json((Req req) -> req.params());
		On.put("/books/{__}/abc").json((Req req) -> req.params());
		On.delete("/tags/{_f}/ref{n:\\d+}/").json((Req req) -> req.params());

		onlyGet("/movies/123");
		onlyGet("/movies/1/");

		onlyPost("/users/abc-def");
		onlyPost("/users/a/");

		onlyPut("/books/12df/abc");
		onlyPut("/books/x-y-z/abc/");

		onlyDelete("/tags/comedy/ref45");
		onlyDelete("/tags/drama/ref3/");
	}

}
