/*
 * Copyright (c) 2012 Orderly Ltd. All rights reserved.
 *
 * This program is licensed to you under the Apache License Version 2.0,
 * and you may not use this file except in compliance with the Apache License Version 2.0.
 * You may obtain a copy of the Apache License Version 2.0 at http://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the Apache License Version 2.0 is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Apache License Version 2.0 for the specific language governing permissions and limitations there under.
 */
package co.orderly.narcolepsy
package marshallers

/**
 * Parent marshalling trait, extended by any unmarshaller
 */
sealed trait Unmarshaller

/**
 * A MultiUnmarshaller can choose between different unmarshallers based on
 * the supplied content type.
 */
trait MultiUnmarshaller extends Unmarshaller {

  /**
   * Abstract method to unmarshal a string into a representation,
   * based on the supplied content type.
   */
  def toRepresentation[R <: Representation](implicit m: Manifest[R], contentType: String, marshalled: String): R =
    toRepresentation[R](contentType, marshalled, m.erasure.asInstanceOf[Class[R]])

  /**
   * See equivalent definition in Unmarshaller above.
   */
  def toRepresentation[R <: Representation](contentType: String, marshalled: String, typeR: Class[R]): R
}

trait ContentTypeUnmarshaller extends MultiUnmarshaller {

  /**
   * Take the contentType argument and discard it
   */
  def toRepresentation[R <: Representation](contentType: String, marshalled: String, typeR: Class[R]): R =
    toRepresentation[R](marshalled, typeR)

  /**
   * Turns the case class's xml into a Representation subclass.
   *
   * Example usage;
   * val order = UnmarshalXml(xml).toRepresentation[Order]
   */
  def toRepresentation[R <: Representation](implicit m: Manifest[R], marshalled: String): R =
    toRepresentation[R](marshalled, m.erasure.asInstanceOf[Class[R]])

  /**
   * Turns the case class's xml into a Representation subclass - use
   * this form with an abstract Representation type, like so:
   *
   * val order = UnmarshalXml(xml).toRepresentation[T](typeOfT)
   *
   * (where you have grabbed and stored typeOfT using another
   * implicit Manifest at the point of declaring T.
   */
  def toRepresentation[R <: Representation](marshalled: String, typeR: Class[R]): R
}