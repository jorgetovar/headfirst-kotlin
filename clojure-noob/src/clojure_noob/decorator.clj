(ns clojure-noob.decorator
    (:require [clojure.spec.alpha :as s])
    )

(def sizes #{:big :tall :ultra-big})

(defn beverage
      ([cost description]
       (beverage cost description :big))
      ([cost description size]
       (if (s/valid? sizes size)
           {:cost cost :description description :size size}
           {:cost cost :description description :size :big}
           )
       )
      )

(def dark-roast-coffee-desc "Dark Roast Coffee")
(def dark-roast-coffee-cost 0.90)

(defn dark-roast-coffee
      ([] (beverage dark-roast-coffee-cost dark-roast-coffee-desc))
      ([size] (beverage dark-roast-coffee-cost dark-roast-coffee-desc size))
      )

(defn add-mocha [coffee]
      (-> coffee
          (update :cost + 0.20)
          (update :description str ", Mocha"))
      )

(defn add-soy [coffee]
      (let [m (update coffee :description str ", Soy") size (:size m)]
           (case size
                 :tall (update m :cost + 0.10)
                 :big (update m :cost + 0.15)
                 :ultra-big (update m :cost + 0.20)
                 m
                 ))
      )

