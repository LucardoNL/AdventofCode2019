; DAY 1 PART 1
(reduce + 
        (map #( - (int (/ % 3)) 2)
             (map #(Integer/parseInt %) 
                  (clojure.string/split (slurp "day1_input.txt") #"\s+")
                  )
             )
        )

; DAY 1 PART 2
(defn recurfuel [mass]
    (loop [totalfuel 0
           fuel (- (int (/ mass 3))2)]
      (if (<= fuel 0)
        totalfuel
    (recur (+ fuel totalfuel) (- (int (/ fuel 3))2))
                                   )))

(reduce +
        (map recurfuel
             (map #(Integer/parseInt %)
                  (clojure.string/split (slurp "day1_input.txt") #"\s+"))))

; DAY 2 PART 1
(defn getinput [input]
  (mapv #(Integer/parseInt %) (clojure.string/split (slurp input) #",")))

(defn manipulator [shortcode intcode operator]
  (assoc intcode
          (nth shortcode 3)
          (operator
            (nth intcode (nth shortcode 2))
            (nth intcode (nth shortcode 1)))
          ))

(defn computer [intcode] 
(for [shortcode (partition 4 intcode)]
  (cond
    (= (nth shortcode 0) 1) (let [intcode (manipulator shortcode intcode +)]) ;nope
    (= (nth shortcode 0) 2) (manipulator shortcode intcode *)
    (= (nth shortcode 0) 99) (nth intcode 0)
    :else ""
    )))

(def input (getinput "day2_input.txt"))
(computer input)