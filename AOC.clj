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

(def opcode
  {1 +
   2 *})

; Used solution by elatedpixel from here https://github.com/elatedpixel/advent-of-code/blob/master/src/advent_2019/day2.clj
(defn computer
  ([program] (reduce computer program (range)))
  ([program i]
   (let [[op a b r] (nth (partition-all 4 4 program) i)]
     (if (= 99 op)
       (reduced program)
       (assoc program r ((opcode op) (program a) (program b)))))))

(defn p1 [input]
  (assoc input 1 12  2 2))

(def input (getinput "day2_input.txt"))

(computer (p1 input))
