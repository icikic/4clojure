(ns for-clojure.core-test
  (:require [clojure.test :refer :all]
            [for-clojure.core :refer :all]))


(deftest caps-only-test
  (testing "Problem 29"
    (is (= (caps-only "HeLlO, WoRlD!") "HLOWRD"))
    (is (empty? (caps-only "nothing")))
    (is (= (caps-only "$#A(*&987Zf") "AZ"))))

(deftest compress-seq-test
  (testing "Problem 30"
    (is (= (apply str (compress-seq "Leeeeeerrroyyy")) "Leroy"))
    (is (= (compress-seq [1 1 2 3 3 2 2 3]) '(1 2 3 2 3)))
    (is (= (compress-seq [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2])))))

(deftest pack-seq-test
  (testing "Problem 31"
    (is (= (pack-seq [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3))))
    (is (= (pack-seq [:a :a :b :b :c]) '((:a :a) (:b :b) (:c))))
    (is (= (pack-seq [[1 2] [1 2] [3 4]]) '(([1 2] [1 2]) ([3 4]))))))

(deftest construct-map-test
  (testing "Problem 61"
    (is (= (construct-map [:a :b :c] [1 2 3]) {:a 1, :b 2, :c 3}))
    (is (= (construct-map [1 2 3 4] ["one" "two" "three"]) {1 "one", 2 "two", 3 "three"}))
    (is (= (construct-map [:foo :bar] ["foo" "bar" "baz"]) {:foo "foo", :bar "bar"}))))