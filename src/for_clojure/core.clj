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

;; 31
(defn pack-seq
  "A function which packs consecutive duplicates into sub-lists."
  [s]
  (partition-by identity s))

;; 32
(defn dupl-seq
  "A function which duplicates each element of a sequence."
  [s]
  (mapcat (fn [x] [x x]) s))

;; 33
(defn repl-seq
  "A function which replicates each element of a sequence a variable number of times."
  [s n]
  (mapcat (fn [x] (repeat n x))  s))

;; 34
(defn my-range
  "A function which creates a list of all integers in a given range."
  [start end]
  (take (- end start) (iterate inc start)))

;; 38
(defn my-max
  "A function which takes a variable number of parameters and returns the maximum value."
  [& args]
  (reduce (fn [x y] (if (> x y) x y)) args))

;; 39
(defn my-interleave
  "A function which takes two sequences and returns the first item from each,
  then the second item from each, then the third, etc."
  [& colls]
  (mapcat (fn [& x] x) colls))

;; 40
(defn my-interpose
  "A function which separates the items of a sequence by an arbitrary value."
  [x s]
  (drop-last (mapcat #([%1 x])) s))

;; 41
(defn drop-nth
  "A function which drops every Nth item from a sequence."
  [s n]
  (mapcat (partial take (dec n)) (partition-all n s)))

;; 42
(defn factorial
  "A function which calculates factorials."
  [x]
  (loop [n x
         f 1]
    (if (= n 1)
      f
      (recur (dec n) (* f n)))))

(defn factorial-v2 [n]
  (reduce * (range 1 (inc n))))

;; 43

;; 49
(defn split-seq
  "A function which will split a sequence into two parts."
  [n s]
  (vector (take n s) (drop n s)))

;; 61
(defn construct-map
  "A function which takes a vector of keys and a vector of values and constructs a map from them."
  [keys vals]
  (loop [map {}
         ks (seq keys)
         vs (seq vals)]
    (if (and ks vs)
      (recur (assoc map (first ks) (first vs))
             (next ks)
             (next vs))
      map)))