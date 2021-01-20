(ns clojure-noob.decorator)

(defn beverage
      ([cost description]
       (beverage cost description "BIG"))
      ([cost description size]
       {:cost cost :description description :size size})
      )

(def dark-roast-coffee-desc "Dark Roast Coffee")
(def dark-roast-coffee-cost 0.90)

(defn dark-roast-coffee
      ([] (beverage dark-roast-coffee-cost dark-roast-coffee-desc))
      ([size] (beverage dark-roast-coffee-cost dark-roast-coffee-desc size))
      )

(defn add-mocha [coffee]

      )

(defn add-soy [coffee]

      )