(ns template-cljfx.main
  "Application entry point."
  (:require
   [cljfx.api :as fx]
   [template-cljfx.ui.root :as root])
  (:gen-class))

(defn -main
  "Launch the JavaFX application."
  [& _args]
  (fx/mount-renderer
   root/state
   (fx/create-renderer
    :middleware (fx/wrap-map-desc assoc :fx/type root/root-view))))
