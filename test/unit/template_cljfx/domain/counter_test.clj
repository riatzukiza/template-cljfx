(ns template-cljfx.domain.counter-test
  "Unit tests for pure counter domain logic."
  (:require
   [clojure.test :refer [deftest is testing]]
   [template-cljfx.domain.counter :as sut]))

(def valid-state {:count 0})

(deftest increment-test
  (testing "increments count by 1"
    (is (= {:count 1} (sut/increment valid-state))))
  (testing "is idempotent on successive calls"
    (is (= {:count 3}
           (-> valid-state
               sut/increment
               sut/increment
               sut/increment)))))

(deftest reset-counter-test
  (testing "resets count to zero"
    (is (= {:count 0} (sut/reset-counter {:count 42})))))
