/*
 * Copyright 2020 Typelevel
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ce3
package laws

import cats.{Eval, Id}
import cats.implicits._
import cats.laws.discipline.{ApplicativeErrorTests, MonadErrorTests}
import cats.laws.discipline.arbitrary.catsLawsArbitraryForEval

import org.specs2.mutable.Specification

import org.typelevel.discipline.specs2.mutable.Discipline

class OutcomeSpec extends Specification with Discipline {
  import OutcomeGenerators._

  checkAll(
    "Outcome[Id, Int, ?]",
    MonadErrorTests[Outcome[Id, Int, ?], Int].monadError[Int, Int, Int])

  checkAll(
    "Outcome[Option, Int, ?]",
    MonadErrorTests[Outcome[Option, Int, ?], Int].monadError[Int, Int, Int])

  checkAll(
    "Outcome[Eval, Int, ?]",
    ApplicativeErrorTests[Outcome[Eval, Int, ?], Int].applicativeError[Int, Int, Int])
}