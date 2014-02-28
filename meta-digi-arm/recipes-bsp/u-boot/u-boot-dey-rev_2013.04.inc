# Copyright (C) 2013 Digi International

SRCBRANCH = "v2013.04/master"

SRCREV_external = ""
SRCREV_internal = "488fd61121314ba13641492c43110ee83eccbbed"
SRCREV = "${@base_conditional('DIGI_INTERNAL_GIT', '1' , '${SRCREV_internal}', '${SRCREV_external}', d)}"

SRC_URI_external = "${DIGI_GITHUB_GIT}/yocto-uboot.git;protocol=git"
SRC_URI_internal = "${DIGI_LOG_GIT}u-boot-denx.git;protocol=git;branch=${SRCBRANCH}"
SRC_URI = "${@base_conditional('DIGI_INTERNAL_GIT', '1' , '${SRC_URI_internal}', '${SRC_URI_external}', d)}"