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
(defn my-rseq
  "A function which reverses a sequence."
  [seq]
  (reduce conj '() seq))

;; #24
(defn my-sum
  "A function which returns the sum of a seqence of numbers"
  [seq]
  (reduce + seq))

;; #25
(defn filter-odd
  "A function which returns only the odd numbers from a sequence"
  [seq]
  (filter odd? seq))

;; #26
(defn fibonacci-seq
  "A function which returns the first X fibonacci numbers."
  [x]
  (take x (map first (iterate (fn [[a b]] [b (+ a b)]) [1 1]))))

;; #27
(defn palindrom
  "A function which returns true if the given sequence is a palindrome."
  [s]
  (= (seq s) (reverse (seq s))))

;; #28
(defn my-flatten
  "A function which flattens a sequence."
  [x]
  (filter (complement sequential?) (tree-seq sequential? seq x)))

;; #29
(defn caps-only
  "A function which takes a string and returns a new string containing only the capital letters."
  [s]
  (apply str (re-seq #"[A-Z]+" s)))

;; #30
(defn compress-seq
  "A function which removes consecutive duplicates from a sequence."
  [s]
  (map first (partition-by identity s)))