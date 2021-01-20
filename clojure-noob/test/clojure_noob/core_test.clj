(ns clojure-noob.core-test
    (:require [clojure.test :refer :all]
              [clojure-noob.factors :refer :all]
              [clojure-noob.decorator :refer :all]))

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


(deftest beverage-test
         (is (= big (:size (beverage 0.20 "dark"))))
         (is (= 0.20 (:cost (beverage 0.20 "dark"))))
         (is (= "dark" (:description (beverage 0.20 "dark"))))
         )

(deftest dark-roast-coffee-test
         (is (= big (:size (dark-roast-coffee))))
         (is (= 0.9 (:cost (dark-roast-coffee))))
         (is (= dark-roast-coffee-desc (:description (dark-roast-coffee))))
         )


(deftest dark-roast-coffee-mocha-test
         (is (= big (:size (dark-roast-coffee))))
         (is (= 1.1 (:cost (add-mocha (dark-roast-coffee)))))
         (is (= "Dark Roast Coffee, Mocha" (:description (add-mocha (dark-roast-coffee)))))
         )

(deftest coffee-soy-test

         (let [coffee  (->
                         (dark-roast-coffee)
                         (add-soy)
                         (add-soy)
                         (add-mocha)
                         )]

              (is (= ultra-big (:size (dark-roast-coffee ultra-big))))
              (is (= "Dark Roast Coffee, Soy, Soy, Mocha"
                     (:description coffee)))

              (is (= 1.4 (:cost coffee)))
              )

         )