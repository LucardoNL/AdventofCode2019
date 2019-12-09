; DAY 1 PART 1 ============================================================================
(reduce + 
        (map #( - (int (/ % 3)) 2)
             (map #(Integer/parseInt %) 
                  (clojure.string/split (slurp "day1_input.txt") #"\s+")
                  )
             )
        )

; DAY 1 PART 2 ============================================================================
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

; DAY 2 PART 1 ============================================================================
(defn getinput [input]
  (mapv #(Integer/parseInt %) (clojure.string/split (slurp input) #",")))

(def opcode
  {1 +
   2 *})

; Used part of solution by elatedpixel from here https://github.com/elatedpixel/advent-of-code/blob/master/src/advent_2019/day2.clj
(defn computer
  ([program]
   (reduce computer program (range)))
  ([program i]
   (let [[op a b r] (nth (partition-all 4 4 program) i)]
     (if (= 99 op)
       (reduced program)
       (assoc program r ((opcode op) (program a) (program b)))))))

(defn p1 [input]
  (assoc input 1 12  2 2))

(def input (getinput "day2_input.txt"))

;(computer (p1 input))

; DAY 2 PART 2 ============================================================================
(defn p2 [input noun verb]
  (computer (assoc input 1 noun 2 verb)))

(defn findoutput [output]
  (for [a (range 0 100) b (range 0 100)
  :let [addrzero (nth (p2 input a b) 0)]
  :when (= addrzero output)]
  [(+ (* 100 a) b)]))

;(findoutput 19690720)

; DAY 3 PART 1 ============================================================================
(defn input [file]
  (clojure.string/split (slurp input) #",")
  )

(defn path [coordsmap]
  (let [pathmap [[0, 0]]])
  )

(defn findclosestcross [path1 path2])
