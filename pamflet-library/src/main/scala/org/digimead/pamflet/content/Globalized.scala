/**
 * Pamflet - a publishing library for short texts.
 *
 * Copyright (c) ... - 2013 Nathan Hamblen & others
 * Copyright (c) 2013 Alexey Aksenov ezh@ezh.msk.ru
 *
 * All rights reserved.
 *
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package org.digimead.pamflet.content

import org.digimead.pamflet.Template

case class Globalized(contents: Map[String, Content], template: Template) {
  def apply(lang: String): Content = contents(lang)
  def defaultLanguage: String = template.defaultLanguage
  def languages: Seq[String] = template.languages
  lazy val defaultContents: Content = apply(defaultLanguage)
}
