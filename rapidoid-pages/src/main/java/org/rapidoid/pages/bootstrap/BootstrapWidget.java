package org.rapidoid.pages.bootstrap;

import org.rapidoid.html.Bootstrap;
import org.rapidoid.html.Tag;
import org.rapidoid.http.HttpExchange;
import org.rapidoid.model.Item;
import org.rapidoid.pages.PageWidget;
import org.rapidoid.pages.Pages;
import org.rapidoid.pages.impl.PageRenderer;
import org.rapidoid.pages.plain.HtmlWidget;
import org.rapidoid.reactive.Var;
import org.rapidoid.util.U;

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

public abstract class BootstrapWidget extends Bootstrap implements PageWidget {

	public static Object _(String multiLanguageText, Object... formatArgs) {
		return HtmlWidget._(multiLanguageText, formatArgs);
	}

	public static <T> Var<T> property(Item item, String property) {
		return HtmlWidget.property(item, property);
	}

	public static Tag<?> template(String templateFileName, Object... namesAndValues) {
		return HtmlWidget.template(templateFileName, namesAndValues);
	}

	public static Tag<?> hardcoded(String content) {
		return HtmlWidget.hardcoded(content);
	}

	@Override
	public void render(HttpExchange x) {
		Tag<?> widget = view(x);
		U.must(widget != null, "No content was set in widget: " + super.toString());
		PageRenderer.get().render(Pages.ctx(x), widget, x);
	}

	@Override
	public String toHTML(HttpExchange x) {
		Tag<?> widget = view(x);
		U.must(widget != null, "No content was set in widget: " + super.toString());
		return PageRenderer.get().toHTML(Pages.ctx(x), widget, x);
	}

}
