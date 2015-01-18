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