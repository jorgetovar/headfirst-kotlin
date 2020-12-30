(ns clojure-noob.core-test
    (:require [clojure.test :refer :all]
              [clojure-noob.core :refer :all]))

(deftest perfect-number?-six
         (testing "6 is a perfect number"
                  (is (= true (perfect-number? 6))))
         )

(deftest factors-six
         (testing "6 factors"
                  (is (= (sort '(1 2 3 6)) (sort (factors 6)))))
         )

(deftest factors-28
         (testing "28 factors"
                  (is (= (sort '(1, 2, 4, 7, 14, 28)) (sort (factors 28))))
                  )
         )


(deftest perfect-number?-big
         (testing "33550336 is a perfect number"
                  (is (= true (perfect-number? 33550336))))
         )

(deftest perfect-numbers-check
         (testing "perfect factors"
                  (is (every? true? (map perfect-number? '(6, 28, 496, 8128, 33550336))))
                  )
         )
(deftest one-hundred-thousands
         (testing "improve performance"
                  (is (= (- 100000 6) (count (filter false? (map perfect-number? (range 2 100000))))))
                  )
         )