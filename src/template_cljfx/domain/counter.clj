(ns template-cljfx.domain.counter
  "Pure counter domain logic. No I/O."
  (:require
   [template-cljfx.law.domain-schema :as schema]
   [malli.core :as m]))

(defn increment
  "Increment counter state. Returns validated new state."
  [{:keys [count] :as state}]
  {:pre  [(m/validate schema/CounterState state)]
   :post [(m/validate schema/CounterState %)]}
  (assoc state :count (inc count)))

(defn reset-counter
  "Reset counter to zero."
  [state]
  {:pre  [(m/validate schema/CounterState state)]
   :post [(m/validate schema/CounterState %)]}
  (assoc state :count 0))
