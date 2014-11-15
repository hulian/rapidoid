package org.rapidoid.pages;

/*
 * #%L
 * rapidoid-pages
 * %%
 * Copyright (C) 2014 Nikolche Mihajlovski
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

import java.util.Map;

import org.rapidoid.html.Tag;
import org.rapidoid.html.TagContext;
import org.rapidoid.html.Tags;
import org.rapidoid.html.impl.TagImpl;
import org.rapidoid.html.impl.TagInternals;
import org.rapidoid.http.Handler;
import org.rapidoid.http.HttpExchange;
import org.rapidoid.pages.impl.PageRenderer;
import org.rapidoid.util.U;

public class EmitHandler implements Handler {

	@Override
	public Object handle(HttpExchange x) throws Exception {

		int hnd = U.num(x.data("hnd"));
		String event = x.data("event");

		U.notNull(hnd, "hnd");
		U.notNull(event, "event");

		TagContext ctx = x.session(Pages.SESSION_CTX);
		Page page = x.session(Pages.SESSION_PAGE);

		Map<Integer, Object> inp = Pages.inputs(x);
		ctx.emit(inp, hnd, event);

		ctx = Tags.context();
		page = U.newInstance(page.getClass());

		x.setSession(Pages.SESSION_CTX, ctx);

		Tag<?> root = page.pageBody(x);
		TagImpl<Tag<?>> rootImpl = ((TagInternals) root).base();

		Map<Integer, String> changes = ctx.changes();

		String html = PageRenderer.get().toHTML(ctx, root, x);

		changes.put(rootImpl.hnd(), html);

		x.json();
		return changes;
	}

}
