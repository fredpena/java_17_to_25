
// Preview feature: Module Import Declarations (JEP 476).
//
// Example of what the syntax looks like:
//
//   import module java.logging;
//
//   import java.logging.Logger;
//
//   public class ModuleImportExample {
//       public static void main(String[] args) {
//           Logger logger = Logger.getLogger("demo");
//           logger.info("Hello from Module Import!");
//       }
//   }
//
// Here we keep it as comments so the file parses on older JDKs.

import module java.logging;

void main() {
    Logger logger = Logger.getLogger("demo");
    logger.info("Hello from Module Import!");
}
