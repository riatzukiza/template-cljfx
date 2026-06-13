(ns template-cljfx.app-e2e-test
  "End-to-end tests: simulate event dispatch and assert rendered state.
   These tests drive app-level state transitions without launching a real JFX stage."
  (:require
   [clojure.test :refer [deftest is testing use-fixtures]]
   [template-cljfx.domain.counter :as counter]
   [template-cljfx.ui.root :as root]))

(defn reset-state-fixture
  "Reset root/state atom before each test."
  [f]
  (reset! root/state {:title "cljfx Template" :count 0})
  (f)
  (reset! root/state {:title "cljfx Template" :count 0}))

(use-fixtures :each reset-state-fixture)

(deftest state-transitions-test
  (testing "initial state has count 0"
    (is (= 0 (:count @root/state))))

  (testing "increment event updates state"
    (swap! root/state counter/increment)
    (is (= 1 (:count @root/state))))

  (testing "multiple increments accumulate"
    (dotimes [_ 4] (swap! root/state counter/increment))
    (is (= 5 (:count @root/state))))

  (testing "reset-counter brings count back to zero"
    (swap! root/state counter/reset-counter)
    (is (= 0 (:count @root/state)))))
