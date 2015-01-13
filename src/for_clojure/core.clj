(ns for-clojure.core)

;; #22
(defn my-count
  "A function which returns the total number of elements in a sequence. Map/reduce version"
  [coll]
  (reduce + (map (fn [_] 1) coll)))

(defn my-count-2
  "A function which returns the total number of elements in a sequence. Map/reduce + constantly version"
  [coll]
  (reduce + (map (constantly 1) coll)))

(defn my-count-3
  "A function which returns the total number of elements in a sequence. Recur version"
  [coll]
  (loop [c coll
         cnt 0]
    (if (seq c)
      (recur (rest c) (inc cnt))
      cnt)))

;; #23
