/**
 * Booklet - a publishing library for short texts.
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

package org.digimead.booklet

import java.io.File
import java.util.Properties

object Settings {
  /** A name of the default language. */
  val defaultLanguageKey = "defaultLanguage"
  /** An exclude regexp that applied to booklet folders. */
  val excludeFolderKey = "excludeFolder"
  /** An exclude regexp that applied to booklet markdowns. */
  val excludeMarkdownKey = "excludeMarkdown"
  /** A name of the file with an index content. */
  val indexMarkdownKey = "indexMarkdown"
  /** Full path to indexMarkdown. */
  val indexMarkdownLocationKey = "indexMarkdownLocation"
  /** Flag indicating whether the index should be generated. */
  val indexKey = "index"
  /** A name of the file with the index template. */
  val indexTemplateKey = "indexTemplate"
  /** Full path to indexTemplate. */
  val indexTemplateLocationKey = "indexTemplateLocation"
  /** A list of the booklet languages. */
  val languagesKey = "languages"
  /** A name of the file with site manifest for offline usage. */
  val manifestKey = "manifest"
  /** Flag indicating whether the generated content should support offline mode. */
  val offlineKey = "offline"
  /** A name of the template directory. */
  val templateDirectoryKey = "templateDirectory"
  /** A name of the PageContent template. */
  val templatePageContentKey = "templatePageContent"
  /** Full path to PageContent template. */
  val templatePageContentLocationKey = "templatePageContentLocation"
  /** A name of the PageDeepContents template. */
  val templatePageDeepContentsKey = "templatePageDeepContents"
  /** Full path to PageDeepContents template. */
  val templatePageDeepContentsLocationKey = "templatePageDeepContentsLocation"
  /** A name of the PageScroll template. */
  val templatePageScrollKey = "templatePageScroll"
  /** Full path to PageScroll template. */
  val templatePageScrollLocationKey = "templatePageScrollLocation"
  /** A name of the file with template properties. */
  val templatePropertiesKey = "templateProperties"
  /** Flag indicating whether the library should be verbose. */
  val verboseKey = "verbose"

  /** Get the name of the default language. */
  def defaultLanguage(implicit properties: Properties): String =
    properties.getProperty(defaultLanguageKey, "en")
  /** Set the name of the default language. */
  def defaultLanguage_=(arg: String)(implicit properties: Properties): Unit =
    properties.setProperty(defaultLanguageKey, arg)

  /** Get the exclude folder regexp. */
  def excludeFolder(implicit properties: Properties): Option[String] =
    Option(properties.getProperty(excludeFolderKey))

  /** Get the exclude markdown regexp. */
  def excludeMarkdown(implicit properties: Properties): Option[String] =
    Option(properties.getProperty(excludeMarkdownKey))

  /** Get index flag. */
  def index(implicit properties: Properties): Boolean =
    properties.getProperty(indexKey, "N").toUpperCase() == "Y"
  /** Set index flag. */
  def index_=(arg: Boolean)(implicit properties: Properties): Unit =
    properties.setProperty(indexKey, if (arg) "Y" else "N")

  /** Get the name of the file with index content. */
  def indexMarkdown(implicit properties: Properties): String =
    properties.getProperty(indexMarkdownKey, "index.markdown")
  /** Set the name of the file with index content. */
  def indexMarkdown_=(arg: String)(implicit properties: Properties): Unit =
    properties.setProperty(indexMarkdownKey, arg)

  /** Get the location of the index content. */
  def indexMarkdownLocation(implicit properties: Properties): Option[File] =
    Option(properties.getProperty(indexMarkdownLocationKey)) flatMap { l ⇒
      val location = new File(l)
      if (location.isFile() && location.canRead())
        Some(location)
      else
        None
    }
  /** Set the location of the index content. */
  def indexMarkdownLocation_=(arg: File)(implicit properties: Properties): Unit =
    properties.setProperty(indexMarkdownLocationKey, arg.getCanonicalPath())

  /** Get the name of index template. */
  def indexTemplate(implicit properties: Properties): String =
    properties.getProperty(indexTemplateKey, "index.scaml")
  /** Set the name of index template. */
  def indexTemplate_=(arg: String)(implicit properties: Properties): Unit =
    properties.setProperty(indexTemplateKey, arg)

  /** Get the location of the index template. */
  def indexTemplateLocation(implicit properties: Properties): Option[File] =
    Option(properties.getProperty(indexTemplateLocationKey)) flatMap { l ⇒
      val location = new File(l)
      if (location.isFile() && location.canRead())
        Some(location)
      else
        None
    }
  /** Set the location of the index template. */
  def indexTemplateLocation_=(arg: File)(implicit properties: Properties): Unit =
    properties.setProperty(indexTemplateLocationKey, arg.getCanonicalPath())

  /** Get all booklet languages. */
  def languages(implicit properties: Properties): Seq[String] = Option(properties.get(languagesKey)).map(_.toString()) match {
    case Some(xs) ⇒ xs.split(",").toSeq map { _.trim }
    case None ⇒ Seq(defaultLanguage(properties))
  }

  /** Get the name of the file with site manifest for offline usage. */
  def manifest(implicit properties: Properties): String =
    properties.getProperty(manifestKey, "booklet.manifest")

  /** Get offline flag. */
  def offline(implicit properties: Properties): Boolean =
    properties.getProperty(offlineKey, "N").toUpperCase() == "Y"
  /** Set offline flag. */
  def offline_=(arg: Boolean)(implicit properties: Properties): Unit =
    properties.setProperty(offlineKey, if (arg) "Y" else "N")

  /** Get the name of directory with booklet template. */
  def template(implicit properties: Properties): String =
    properties.getProperty(templateDirectoryKey, "template")

  /** Get the name of the file with template for PageContent. */
  def templatePageContent(implicit properties: Properties): String =
    properties.getProperty(templatePageContentKey, "pageContent.scaml")

  /** Get the location of the PageContent template. */
  def templatePageContentLocation(implicit properties: Properties): Option[File] =
    Option(properties.getProperty(templatePageContentLocationKey)) flatMap { l ⇒
      val location = new File(l)
      if (location.isFile() && location.canRead())
        Some(location)
      else
        None
    }
  /** Set the location of the PageContent template. */
  def templatePageContentLocation_=(arg: File)(implicit properties: Properties): Unit =
    properties.setProperty(templatePageContentLocationKey, arg.getCanonicalPath())

  /** Get the name of the file with template for DeepContents. */
  def templatePageDeepContents(implicit properties: Properties): String =
    properties.getProperty(templatePageDeepContentsKey, "pageDeepContents.scaml")

  /** Get the location of the PageDeepContents template. */
  def templatePageDeepContentsLocation(implicit properties: Properties): Option[File] =
    Option(properties.getProperty(templatePageDeepContentsLocationKey)) flatMap { l ⇒
      val location = new File(l)
      if (location.isFile() && location.canRead())
        Some(location)
      else
        None
    }
  /** Set the location of the PageDeepContents template. */
  def templatePageDeepContentsLocation_=(arg: File)(implicit properties: Properties): Unit =
    properties.setProperty(templatePageDeepContentsLocationKey, arg.getCanonicalPath())

  /** Get the name of the file with template for PageScroll. */
  def templatePageScroll(implicit properties: Properties): String =
    properties.getProperty(templatePageScrollKey, "pageScroll.scaml")

  /** Get the location of the PageScroll template. */
  def templatePageScrollLocation(implicit properties: Properties): Option[File] =
    Option(properties.getProperty(templatePageScrollLocationKey)) flatMap { l ⇒
      val location = new File(l)
      if (location.isFile() && location.canRead())
        Some(location)
      else
        None
    }
  /** Set the location of the PageScroll template. */
  def templatePageScrollLocation_=(arg: File)(implicit properties: Properties): Unit =
    properties.setProperty(templatePageScrollLocationKey, arg.getCanonicalPath())

  /** Get the name of file with booklet properties. */
  def templateProperties(implicit properties: Properties): String =
    properties.getProperty(templatePropertiesKey, "booklet.properties")

  /** Get verbose flag. */
  def verbose(implicit properties: Properties): Boolean =
    properties.getProperty(verboseKey, "N").toUpperCase() == "Y"
  /** Set verbose flag. */
  def verbose_=(arg: Boolean)(implicit properties: Properties): Unit =
    properties.setProperty(verboseKey, if (arg) "Y" else "N")
}