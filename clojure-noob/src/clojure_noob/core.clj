(ns clojure-noob.core
    (:gen-class))

(defn factor? [number r]
      (zero? (rem number r)))

(defn factors [number]
      (filter #(factor? number %) (range 1 (inc number)))
      )

(defn sum-factors [number]
      (reduce + (factors number)))

(defn perfect-number? [number]
      (= number (- (sum-factors number) number))
      )


(defn -main
      "I don't do a whole lot ... yet."
      [& args]
      (println "Hello, World!"))
