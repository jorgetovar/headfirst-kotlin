(ns clojure-noob.core-test
    (:require [clojure.test :refer :all]
              [clojure-noob.core :refer :all]))

(deftest perfect-number?-six
         (testing "6 is a perfect number"
                  (is (= true (perfect-number? 6))))
         )

(deftest factors-six
         (testing "6 factors"
                  (is (= '(1 2 3 6) (factors 6))))
         )

(deftest factors-28
         (testing "28 factors"
                  (is (= '(1, 2, 4, 7, 14, 28) (factors 28)))
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
;(range 2 100000)