# Copyright (C) 2013 Digi International.

SUMMARY = "Digi's ubootenv tool"
SECTION = "base"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

DEPENDS = "libdigi nvram"

SRC_URI = " \
    file://env_funcs.c \
    file://env_funcs.h \
    file://environment.h \
    file://main_env.c \
"

S = "${WORKDIR}"

GIT_SHA1 = "$(cd ${THISDIR} && git rev-parse --short=7 HEAD)"

EXTRA_CFLAGS = "-Wall -DLINUX -DGIT_SHA1=\"${GIT_SHA1}\" -I${STAGING_INCDIR}/libdigi"

do_compile() {
	${CC} ${CFLAGS} ${EXTRA_CFLAGS} -c -o main_env.o main_env.c
	${CC} ${CFLAGS} ${EXTRA_CFLAGS} -c -o env_funcs.o env_funcs.c
	${CC} ${LDFLAGS} -o ubootenv main_env.o env_funcs.o -lnvram -ldigi
}

do_install() {
	mkdir -p ${D}${base_sbindir}
	install -m 0755 ubootenv ${D}${base_sbindir}/
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
