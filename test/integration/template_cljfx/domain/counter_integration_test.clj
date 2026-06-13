(ns template-cljfx.domain.counter-integration-test
  "Integration tests: domain + schema contract together."
  (:require
   [clojure.test :refer [deftest is testing]]
   [template-cljfx.domain.counter :as counter]
   [template-cljfx.law.domain-schema :as schema]
   [malli.core :as m]))

(deftest increment-satisfies-schema-test
  (testing "increment output always satisfies CounterState contract"
    (let [result (counter/increment {:count 0})]
      (is (m/validate schema/CounterState result)))))

(deftest stateful-sequence-test
  (testing "sequence of increments stays within schema bounds"
    (let [states (reductions (fn [s _] (counter/increment s))
                              {:count 0}
                              (range 100))]
      (is (every? #(m/validate schema/CounterState %) states)))))
