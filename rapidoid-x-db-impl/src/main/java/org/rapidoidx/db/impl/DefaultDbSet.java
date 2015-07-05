package org.rapidoidx.db.impl;

/*
 * #%L
 * rapidoid-x-db-impl
 * %%
 * Copyright (C) 2014 - 2015 Nikolche Mihajlovski and contributors
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * #L%
 */

import java.util.LinkedHashSet;
import java.util.List;

import org.rapidoid.annotation.Authors;
import org.rapidoid.annotation.Since;
import org.rapidoidx.db.Database;
import org.rapidoidx.db.DbSet;

@Authors("Nikolche Mihajlovski")
@Since("3.0.0")
public class DefaultDbSet<E> extends DefaultDbCollection<E> implements DbSet<E> {

	public DefaultDbSet(Database db, Object holder, String relation) {
		super(db, holder, relation, new LinkedHashSet<Long>());
	}

	public DefaultDbSet(Database db, Object holder, String relation, List<? extends Number> ids) {
		this(db, holder, relation);
		initIds(ids);
	}

}
