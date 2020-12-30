(ns clojure-noob.core
    (:gen-class))

(defn factor? [number r]
      (zero? (rem number r)))

(defn factors [number]
      (for [n (range 1 (inc number)) :when (factor? number n)] n))

(defn sum-factors [number]
      (reduce + (factors number)))

(defn perfect-number? [number]
      (= number (- (sum-factors number) number))
      )


(defn -main
      "I don't do a whole lot ... yet."
      [& args]
      (println "Hello, World!"))
