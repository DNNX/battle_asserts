(ns battle-asserts.issues.rotate-sequence-test
  (:require [clojure.test :refer :all]
            [clojure.test.check.properties :as prop]
            [clojure.test.check.clojure-test :as ct]
            [test-helper :as h]
            [battle-asserts.issues.rotate-sequence :as issue]))

(ct/defspec spec-solution
  20
  (prop/for-all [v (issue/arguments-generator)]
                (=  (sort (apply issue/solution v))
                    (sort (second v)))))

(deftest test-solution
  (h/generate-tests issue/test-data issue/solution))
