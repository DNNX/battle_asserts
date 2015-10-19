(ns battle-asserts.issues.next-lucky-number-test
  (:require [clojure.test :refer :all]
            [clojure.test.check.properties :as prop :include-macros true]
            [clojure.test.check.clojure-test :as ct :include-macros true]
            [test-helper :as h]
            [clojure.string :as s]
            [battle-asserts.issues.next-lucky-number :as issue]))

(ct/defspec test-solution
  20
  (prop/for-all [v (issue/arguments-generator)]
                (empty? (s/replace (apply issue/solution v) #"[5|3]" ""))))

(h/generate-tests issue/test-data issue/solution)
