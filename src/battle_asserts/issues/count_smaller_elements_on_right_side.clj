(ns battle-asserts.issues.count-smaller-elements-on-right-side
  (:require [clojure.test.check.generators :as gen]
            [faker.generate :as faker]))

(def level :easy)

(def description "Write a function to count number of smaller elements on right of each element in an array.")

(defn arguments-generator []
  (gen/tuple (gen/vector gen/int)))

(def test-data
  [{:expected [6 1 1 1 0 1 0]
    :arguments [[12 1 2 3 0 11 4]]}
   {:expected [4 3 2 1 0]
    :arguments [[5 4 3 2 1]]}
   {:expected [0 0 0 0 0]
    :arguments [[1 2 3 4 5]]}
   {:expected [6 5 7 4 1 3 0 2 0 0]
    :arguments [[7 6 10 5 2 8 1 9 3 4]]}])

(defn count-smaller [value array]
  (count (filter #(> value %) array)))

(defn solution [array]
  (map-indexed #(count-smaller %2 (subvec array (inc %1))) array))
