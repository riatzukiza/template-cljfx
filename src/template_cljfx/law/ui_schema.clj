(ns template-cljfx.law.ui-schema
  "Malli schemas for UI-layer data shapes."
  (:require [malli.core :as m]))

(def AppState
  [:map
   [:title  :string]
   [:count  [:int {:min 0}]]])
